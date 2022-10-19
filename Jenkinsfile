pipeline{
    agent any
    stages{
        stage('SCM Checkout'){
               steps{
                    git credentialsId: '863c7679-aeb0-4114-bcbb-f709d12eab99', url: 'https://github.com/mohamed224/springboot-mongodb-crud-example'
               }
            }
            stage('Mvn Package'){
                steps{
                    bat 'mvn clean package'
                }
            }
            stage('Build docker image'){
                steps{
                    bat 'docker build -t mohamed224/springboot-mongo-app:1.0.0 .'
                }
            }
            stage('Push docker image'){
               steps{
                     withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPWD')]) {
                                        bat "docker login -u mohamed224 -p ${dockerHubPWD}"
                                    }
                                    bat 'docker push mohamed224/springboot-mongo-app:1.0.0'
               }
            }
            stage('Run container'){
                steps{
                       bat 'docker rm -f springboot-mongodb-app mongodb'
                       bat 'docker compose up -d'
                }
            }
    }
}