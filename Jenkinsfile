pipeline {
    environment {
        DOCKER_IMAGE_NAME = "springbootapp"
        DOCKER_REGISTRY_CREDENTIALS = 'DockerId'
//         DOCKER_IMAGE_TAG = 'latest' // Tag for the Docker image
//         DOCKER_REGISTRY_IMAGE = "ashish142/${DOCKER_IMAGE_NAME}" // Define the registry image here
    }
    agent any
    triggers {
        pollSCM('* * * * *')
//         pollSCM('H/5 * * * *')
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
                    echo 'Remove existing images'
                    sh '''
                    docker images | grep "ashish142/springbootapp" | awk '{print $3}' |xargs docker rmi -f
                    '''
                    echo 'Building...'
                    // Build the Docker image
                    DOCKER_IMAGE_NAME = docker.build("ashish142/${DOCKER_IMAGE_NAME}")
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_REGISTRY_CREDENTIALS) {
                        // Tag and push the Docker image
                        def tagNumber = "${BUILD_NUMBER}"
                        DOCKER_IMAGE_NAME.tag(tagNumber)
                        DOCKER_IMAGE_NAME.push(tagNumber)
                    }
                }
            }
        }
        stage("deployment"){
            steps{
                    echo 'Starting container'
                   sh'''
                    docker container run --rm --name springbootapp -p 8081:8081 ashish142/springbootapp:latest
                    '''
            }
        }
        
    }
}
