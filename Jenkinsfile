pipeline {
    agent any

    // tools {
    //     // Install the Maven version configured as "M3" and add it to the path.
    //     maven "M3"
    // }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/shelfsrdjan/ui-init-setup.git'
                bat 'C:\ProgramData\Jenkins\.jenkins\workspace\pipe-demo\gradlew'
                bat './gradlew build'
            }
            
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }   
    }
}
