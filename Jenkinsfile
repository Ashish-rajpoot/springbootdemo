pipeline {
    environment {
        DOCKER_REGISTRY = 'ashish142/springboot-demo'
        DOCKER_IMAGE_NAME = ''
        DOCKER_REGISTRY_CREDENTIALS = 'docker'
    }
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './gradlew clean build'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    DOCKER_IMAGE_NAME = docker.build("${DOCKER_REGISTRY}:${BUILD_NUMBER}")
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    // Log in to Docker registry
                    docker.withRegistry(DOCKER_REGISTRY, DOCKER_REGISTRY_CREDENTIALS) {
                        // Push Docker image
                        DOCKER_IMAGE_NAME.push()
                    }
                }
            }
        }
    }
}
