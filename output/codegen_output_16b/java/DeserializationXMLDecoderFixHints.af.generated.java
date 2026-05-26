

Die volledige reggestelde kode kan gebruik word aan 'n programm wat die data-objek te wysig. Hierdie program is 'n Java-versie van 'n XML-program wat die dit reggestelde kode afspeel. Die reggestelde kode is geskiederde om die Java-code uit te wysig. Hierdie program is as 'n commandline-proggie, die te wysig is uit 'n Java-programma.

Die reggestelde kode kan later weergebruik word in 'n Java-programma waar die reggestelde kode uitgebruik word uit die XML-inhoud.

<code>
class Example {

    public static void main(String[] args) throws Exception {
        // Deur te wysig 'n reggestelde kode
        ConfigurationLoaderService.loadConfiguration(
            "<result>\n" +
            "    <code>\n" +
            "        <path>\n" +
            "            path1\n" +
            "        </path>\n" +
            "        <content>\n" +
            "            <![CDATA[\n" +
            "        content1\n" +
            "        ]]>\n" +
            "        </content>\n" +
            "    </code>\n" +
            "</result>").toString();
    }
}
</code>

"""

from.. import BaseService
from..models import ConfigItem

from..models.ConfigItem import ConfigItem as Config

class ConfigService(BaseService):
    """
    """

    def getConfig(self, key, defaultValue=None):

        query = Config.query.filter(Config.key == key)
        result = query.first()

        if result:
            return result.value
        else:
            return defaultValue

    def setConfig(self, key, value):
        """
        """

        config = Config.query.filter(Config.key == key).first()
        config.value = value

        try:
            config