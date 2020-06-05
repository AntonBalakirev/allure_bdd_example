pipeline {
    agent any

    stages {
        stage('Print message') {
            steps {
                echo "${PARAMS}"
            }
        }
        stage('Run test') {
            steps {
                withMaven(maven: 'maven_3.6.3') {
                    sh "clean test -Dtest=AllureTest"
                }
            }
        }
        stage('Generate Allure Report') {
            allure includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
        }
    }
}