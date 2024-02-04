pipeline {
    environment {
        // Define the Docker registry URL
        DOCKER_REGISTRY = 'ashish142/springboot-demo'
        // Define the Docker image name
        DOCKER_IMAGE_NAME = ''
        // Define the JAR file name
        JAR_FILE_NAME = 'your-app.jar'
        DOCKER_REGISTRY_CREDENTIALS = 'docker'
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
//             steps {
//                 script {
//                     // Authenticate with Docker registry using Jenkins credentials
//                     withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
//                         // Log in to Docker registry
//                         sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} ${DOCKER_REGISTRY}"
//
//                         // Build Docker image with the JAR file
//                         sh "docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME} ."
//
//                         // Push Docker image to the registry
//                         sh "docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}"
//                     }
//                 }
//             }
//         }
            stage('Building our image') {
                steps{
                    script {
                    DOCKER_IMAGE_NAME = docker.build DOCKER_REGISTRY + ":$BUILD_NUMBER"
                    }
                }
            }
            stage('Build and Push Docker Image') {
                steps {
                    script {
                        // Log in to Docker registry
                        docker.withRegistry(DOCKER_REGISTRY, DOCKER_REGISTRY_CREDENTIALS) {
                            // Build and push Docker image
                            DOCKER_IMAGE_NAME.push()
                        }
                    }
                }
            }
    }
}