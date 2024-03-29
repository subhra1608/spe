pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'calculator'
        GITHUB_REPO_URL = 'https://github.com/subhra1608/spe.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'master', url: "${GITHUB_REPO_URL}"
                }
            }
        }
        stage('Maven Build'){
        	steps{
            	echo 'This is job building stage'
            	//maven clean and install command to build the target folder
            	sh "mvn clean install"
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', 'DockerHubCred') {
                    sh 'docker tag calculator subhra1608/calculator:latest'
                    sh 'docker push subhra1608/calculator'
                    }
                 }
            }
        }
        stage('Delete Docker Image from Local'){
                steps {
                    sh 'docker rmi subhra1608/calculator'
                }
            }
   stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'plybk.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }

    }
}
