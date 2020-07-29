pipeline {
    agent any

    stages {
        stage('Print message') {
            steps {
                echo "${BRANCH}"
            }
        }
        stage('Run test') {
            steps {
                withMaven(maven: 'maven_3.6.3') {
                    bat 'mvn clean test -Dcucumber.filter.tags="' + ${TAG} + '" -Dmaven.test.failure.ignore=true'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        report: 'target/allure-report',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}