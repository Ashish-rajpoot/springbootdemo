pipeline {
    environment {
        DOCKER_IMAGE_NAME = "ashish142/springbootapp"
        DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
        DOCKER_IMAGE_TAG = 'latest' // Tag for the Docker image
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
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry("", DOCKER_REGISTRY_CREDENTIALS) {
                        // Push Docker image to Docker Hub
                        DOCKER_IMAGE_NAME.push('latest')
                    }
                }
            }
        }
    }
}
//         stage('Tag Docker Image') {
//             steps {
//                 script {
//                     // Tag Docker image
//                     docker.image("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}").tag("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}")
//                 }
//             }
//         }
// pipeline {
//     environment {
// //         DOCKER_REGISTRY = 'https://hub.docker.com/v2/'
//
//        //  DOCKER_REGISTRY = 'https://hub.docker.com/repository/docker/ashish142/springboot-demo'
//         DOCKER_IMAGE_NAME = 'app'
//         DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
//     }
//     agent any
//     triggers {
//         pollSCM('* * * * *')
//     }
//     stages {
//         stage('Build') {
//             steps {
//                 echo 'Building...'
//                 sh './gradlew clean bootJar'
//             }
//         }
//         stage('Building our image') {
//             steps {
//                 script {
//                     DOCKER_IMAGE_NAME = docker.build("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}")
//                 }
//             }
//         }
// //         stage('Docker Build Stage') {
// //                     steps {
// //                         echo '::::: Hello, Docker Build stage  :::::'
// //                         sh 'docker image build -t ecom-webservice .'
// //                     }
// //                 }
// //                 stage('Tag docker image'){
// //                     steps {
// //                         sh 'docker tag ecom-webservice ashish142/ecom-webservice:1.0.0'
// //                     }
// //                 }
// //                 stage('Push docker image'){
// //                     steps {
// //                         sh 'sudo docker push ashish142/ecom-webservice:1.0.0'
// //                     }
// //                 }
//         stage('Build and Push Docker Image') {
//             steps {
//                 script {
//                     docker.withRegistry("", DOCKER_REGISTRY_CREDENTIALS) {
//                                            // Build and push Docker image
// //                                            DOCKER_IMAGE_NAME = docker.build("my-image:${BUILD_NUMBER}")
//                                            DOCKER_IMAGE_NAME.push()
//                     }
//                 }
//             }
//         }
//     }
// }
