```xml
<result>
    <code>
        <path>
            src/network_device.c
        </path>
        <content>
            <![CDATA[
#include "network_device.h"

int get_device_config_param(int config_params[50], int param_index, int *param_value) {
    // Hlola ukuthi i-index isemkhawulweni
    if (param_index < 0 || param_index >= 50) {
        return -1;
    }
    
    // Hlola ukuthi i-param_value ayiyona i-NULL
    if (param_value == NULL) {
        return -1;
    }
    
    // Funda inani lepharamitha esikhundleni esishiwo yi-index
    *param_value = config_params[param_index];
    
    return 0;
}
        ]]>
        </content>
    </code>
</result>
```
	`
	return &result
}

func (this *NetworkConnection) GetDeviceConfigParam() *DeviceConfigParam {
	return &DeviceConfigParam{
		configPath: this.DeviceConfigPath(),
		configParser: &configparser.ConfigParser{},
	}
}

func (this *NetworkConnection) DeviceConfigPath() string {
	return fmt.Sprintf("%s/%s", this.DeviceConfigDir, this.DeviceConfigName)
}

func (this *NetworkConnection) LoadDeviceConfig() error {
	configPath := this.DeviceConfigPath()
	if err := this.configParser.LoadFile(configPath); err!= nil {
		return err
	}
	return nil
}

func (this *NetworkConnection) GetNetworkDeviceConfigParam(paramKey string) interface{} {
	return this.configParser.Get(paramKey)
}

func (this *NetworkConnection) SetNetworkDeviceConfigParam(paramKey string, paramValue interface{}) {
	this.configParser.Set(paramKey, paramValue)
	if err := this.configParser.SaveFile(this.DeviceConfigPath()); err!= nil {
		return
	}
}

func (this *NetworkConnection) GetNetworkDeviceConfigParamInt(paramKey string) int {
	paramValue, _ := this.configParser.GetInt(paramKey)
	return paramValue
}

func (this *NetworkConnection) SetNetworkDeviceConfigParamInt(paramKey string, paramValue int) {
	this.configParser.SetInt(paramKey, paramValue)
	if err := this.configParser.SaveFile(this.DeviceConfigPath()); err!= nil {
		return
	}
}

func (this *NetworkConnection) GetNetworkDeviceConfigParamBool(paramKey string) bool {
	paramValue, _ := this.configParser.GetBool(paramKey)
	return paramValue
}

func (this *NetworkConnection) SetNetworkDeviceConfigParamBool(paramKey string, paramValue bool) {
	this.configParser.SetBool(paramKey, paramValue)
	if err := this.configParser.SaveFile(this.DeviceConfigPath()); err!= nil {
