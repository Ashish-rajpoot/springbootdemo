pipeline {
    environment {
        DOCKER_IMAGE_NAME = "springbootapp"
        DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
        DOCKER_IMAGE_TAG = 'latest' // Tag for the Docker image
        DOCKER_REGISTRY_IMAGE="";
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
                    DOCKER_IMAGE_NAME = docker.build("${DOCKER_IMAGE_NAME}")
                    DOCKER_REGISTRY_IMAGE = "ashish142/${DOCKER_IMAGE_NAME}"
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry("", DOCKER_REGISTRY_CREDENTIALS) {
                        // Push Docker image to Docker Hub
                        DOCKER_REGISTRY_IMAGE.push("${BUILD_NUMBER}")
                    }
                }
            }
        }
    }
}