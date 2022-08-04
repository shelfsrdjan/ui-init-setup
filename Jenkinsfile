pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/shelfsrdjan/ui-init-setup'
                bat './gradlew clean'
            }
        }

        stage('Test') {
                    steps {
                        './gradle build'
                        // gradle test
                    }

                    post {
                        always {
                            junit '**/build/test-results/test/TEST-*.xml'
                            // path to .xml
                        }
                    }

        }
    }
}
