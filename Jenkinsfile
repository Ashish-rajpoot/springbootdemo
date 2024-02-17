pipeline {
    environment {
        DOCKER_IMAGE_NAME = "springbootapp"
        DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
        DOCKER_REGISTRY_IMAGE = "ashish142/${DOCKER_IMAGE_NAME}" // Define the registry image here
    }
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh './gradlew clean bootJar'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    // Build the Docker image
                    DOCKER_IMAGE_NAME = docker.build("${DOCKER_IMAGE_NAME}")
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_REGISTRY_CREDENTIALS) {
                        // Tag and push the Docker image
                        def imageNameWithTag = "ashish142/${DOCKER_IMAGE_NAME}"
                        def tag = BUILD_NUMBER
//                         DOCKER_REGISTRY_IMAGE.tag(${BUILD_NUMBER})
                        imageNameWithTag.push(tag)
                    }
                }
            }
        }
    }
}
