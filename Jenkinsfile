pipeline {
    environment {
        // Define the Docker registry URL
        DOCKER_REGISTRY = 'your-docker-registry-url'
        // Define the Docker image name
        DOCKER_IMAGE_NAME = 'your-docker-image-name'
        // Define the JAR file name
        JAR_FILE_NAME = 'your-app.jar'
    }
    agent any
    triggers{
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Docker Build and Push') {
            steps {
                script {
                    // Authenticate with Docker registry using Jenkins credentials
                    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        // Log in to Docker registry
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} ${DOCKER_REGISTRY}"

                        // Build Docker image with the JAR file
                        sh "docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME} ."

                        // Push Docker image to the registry
                        sh "docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}"
                    }
                }
            }
        }
    }
}