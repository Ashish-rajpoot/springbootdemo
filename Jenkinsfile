pipeline {
    environment {
        DOCKER_REGISTRY = 'https://hub.docker.com/'

       //  DOCKER_REGISTRY = 'https://hub.docker.com/repository/docker/ashish142/springboot-demo'
        DOCKER_IMAGE_NAME = 'ashish142/springboot-demo'
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
                    DOCKER_IMAGE_NAME = docker.build("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}")
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry("${DOCKER_REGISTRY}", DOCKER_REGISTRY_CREDENTIALS) {
                                           // Build and push Docker image
//                                            DOCKER_IMAGE_NAME = docker.build("my-image:${BUILD_NUMBER}")
                                           DOCKER_IMAGE_NAME.push()
                    }
                }
            }
        }
    }
}
