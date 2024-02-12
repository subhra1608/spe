pipeline{

    environment{
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')

	}

	agent any

    stages{
        stage('Git clone'){
            steps{
                git branch: 'master', url: 'https://github.com/amanverma685/spe_mini_project.git'
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
                sh 'docker build -t docker685/jenkins-docker-hub .'
              }
            }
        stage('Login into DockerHub') {
              steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
              }
            }
        stage('Push to DockerHub') {
              steps {
                sh 'docker push docker685/jenkins-docker-hub'
              }
            }
        stage('Delete Docker Image from Local'){
                steps {
                    sh 'docker rmi docker685/jenkins-docker-hub'
                }
            }


        stage("Ansible Deploy"){
            steps{
//                 ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'plybk.yml'
                    sh "ansible-playbook -i inventory plybk.yml"
            }
        }
    }
}
