#include <Arduino.h>
#include <WiFi.h>
#include <HTTPClient.h>
#include <Update.h>

// WiFi credentials
const char* ssid = "your_SSID";
const char* password = "your_PASSWORD";

// Firmware update server URL
const char* firmwareUrl = "http://your-server.com/firmware.bin";

void setup() {
  Serial.begin(115200);
  Serial.println("Starting firmware update...");

  // Connect to WiFi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  // Perform firmware update
  if (performUpdate()) {
    Serial.println("Update successful. Rebooting...");
    ESP.restart();
  } else {
    Serial.println("Update failed.");
  }
}

void loop() {
  // Nothing to do here
}

bool performUpdate() {
  HTTPClient http;
  http.begin(firmwareUrl);
  int httpCode = http.GET();

  if (httpCode == HTTP_CODE_OK) {
    int contentLength = http.getSize();
    if (contentLength > 0) {
      bool canBegin = Update.begin(contentLength);
      if (canBegin) {
        WiFiClient* stream = http.getStreamPtr();
        size_t written = Update.writeStream(*stream);
        if (written == contentLength) {
          if (Update.end()) {
            return true;
          } else {
            Serial.println("Update failed: " + String(Update.getError()));
          }
        } else {
          Serial.println("Update failed: Written size mismatch");
        }
      } else {
        Serial.println("Not enough space for update");
      }
    } else {
      Serial.println("Invalid content length");
    }
  } else {
    Serial.println("HTTP request failed: " + String(httpCode));
  }

  http.end();
  return false;
}