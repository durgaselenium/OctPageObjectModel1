pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                // 👉 Replace below with your GitHub repo
                git 'https://github.com/YourGitHubUsername/YourProjectRepo.git'
            }
        }

        stage('Build Project') {
            steps {
                bat "mvn clean compile -Dmaven.test.failure.ignore=true"
            }
        }

        stage('Run Regression Automation Tests') {
            steps {
                bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
            }
        }

        stage('Publish Allure Regression Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }

        stage('Publish ChainTest Regression Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/chaintest', 
                    reportFiles: 'Index.html', 
                    reportName: 'Regression ChainTest Report'
                ])
            }
        }

        stage('Run Sanity Automation Tests') {
            steps {
                bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_sanity.xml"
            }
        }

        stage('Publish Allure Sanity Report') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }

        stage('Publish ChainTest Sanity Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/chaintest', 
                    reportFiles: 'Index.html', 
                    reportName: 'Sanity ChainTest Report'
                ])
            }
        }
    }

    post {
        success {
            echo "✅ Build and Test Execution Successful! Reports generated in Jenkins."
        }
        failure {
            echo "❌ Build Failed. Please check console logs and reports."
        }
    }
}