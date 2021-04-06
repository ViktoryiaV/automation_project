package my.testframework.utils

import groovy.util.logging.Log4j

@Log4j
class ConfigsReader {

    static String loadProperty(String key, String fileName = 'configuration') {
        Properties props = new Properties()
        try {
            FileInputStream filePath = new FileInputStream("target/test-classes/${fileName}.properties")
            props.load(filePath)
            filePath.close()
        } catch (IOException e) {
            log.error(e.message, e)
            throw e
        }
        def property = props.getProperty(key)
        log.info("$key=$property")
        property
    }
    final static String BROWSER_NAME
    final static String BASE_URL
    final static boolean IS_HEADLESS = false

    static {
        BROWSER_NAME = loadProperty('browser')
        BASE_URL = loadProperty('base.url')
        if (loadProperty('is.headless') == 'true') {
            IS_HEADLESS = true
        }

    }

}
