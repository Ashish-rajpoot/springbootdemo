pipeline {
    environment {
        DOCKER_REGISTRY = 'ashish142/springboot-demo'
        DOCKER_IMAGE_NAME = ''
        DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
    }
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './gradlew clean bootJar'
            }
        }
        stage('Building our image') {
            steps {
                script {
                echo "DOCKER_REGISTRY_CREDENTIALS : ${DOCKER_REGISTRY_CREDENTIALS}"
//                     DOCKER_IMAGE_NAME = docker.build("${DOCKER_REGISTRY}:${BUILD_NUMBER}")
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry(${DOCKER_REGISTRY}, DOCKER_REGISTRY_CREDENTIALS) {
                                           // Build and push Docker image
                                           DOCKER_IMAGE_NAME = docker.build("my-image:${BUILD_NUMBER}")
                                           DOCKER_IMAGE_NAME.push()
                    }
                }
            }
        }
    }
}
