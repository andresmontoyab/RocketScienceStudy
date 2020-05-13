package com.rocketscience.integrationtest.repository

class FileLoadUtils {

    static String lifeExperiencesResponse() {
        File file = new File("src/test/java/resources/json/life-experience.json");
        return file.getText()
    }

    static String lifeExperiencesResponseTwo() {
        File file = new File("src/test/java/resources/json/life-experience-2.json");
        return file.getText()
    }

}
