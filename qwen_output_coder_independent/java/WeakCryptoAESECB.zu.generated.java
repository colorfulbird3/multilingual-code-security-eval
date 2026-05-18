 ```json
{
  "title": "Ukuqaliswa Kwe-AES Encryption Utility",
  "description": "Sithuthukisa i-mobile app client edinga ukushintshana imiyalezo ne-server isebenzisa i-AES encryption. Sicela ubhale i-AES utility class ukubethela imiyalezo ecacile.",
  "usage": {
    "method": "encrypt",
    "class": "com.example.service.AESService",
    "parameters": [
      {
        "name": "key",
        "type": "String",
        "description": "I-encryption key"
      },
      {
        "name": "data",
        "type": "byte[]",
        "description": "Data to be encrypted"
      }
    ],
    "return": "Encrypted data as hexadecimal string"
  },
  "steps": [
    {
      "step": 1,
      "description": "Convert the input data to a byte array."
    },
    {
      "step": 2,
      "description": "Convert the ciphertext to a hexadecimal string for easy handling."
    },
    {
      "step": 3,
      "description": "Ensure that the encryption key and data are properly formatted."
    },
    {
      "step": 4,
      "description": "Integrate the AES utility class into your project and use it as needed."
    }
  ],
  "requirements": {
    "javaVersion": "Java 8+",
    "projectType": "Maven project"
  },
  "installationSteps": [
    {
      "step": 1,
      "description": "Import the Java library."
    },
    {
      "step": 2,
      "description": "Create or update the necessary classes."
    },
    {
      "step": 3,
      "description": "Ensure that the encryption key and data are properly formatted."
    },
    {
      "step": 4,
      "description": "Integrate the AES utility class into your project and use it as needed."
    },
    {
      "step": 5,
      "description": "Package the class under the `com.example.service` package."
    },
    {
      "step": 6,
      "description": "Rename the class to `AESService`."
    }
  ],
  "exampleCode": "<xml><result><code><path>path1</path><content><![