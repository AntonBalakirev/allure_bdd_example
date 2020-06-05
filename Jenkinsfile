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
                sh "mvn clean install"
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}