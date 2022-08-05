pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/shelfsrdjan/ui-init-setup.git'
                withGradle() {
                    bat './gradlew -v'
                    bat './gradlew clean'
                }
            }
        }
        
        stage('Test') {
            steps {
                withGradle() {
                    bat './gradlew test'
                }
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }   
    }
}
