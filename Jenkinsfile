pipeline {
    
    agent any

    tools {
        gradle 'GRADLE_PATH'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/shelfsrdjan/ui-init-setup.git'
                bat 'gradle clean'
            }
        }
        
        stage('Test') {
            steps {
                bat 'gradle build'
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                    // archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage('Publish') {
            steps {
                bat 'gradle assemble'
            }
            post {
                success {
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
    }
}
