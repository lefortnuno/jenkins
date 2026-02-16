node {
        stage('Clone') {  
            checkout scm
        }

        stage('Build Image') { 
            app = docker.build("ac2i/nginx") 
        }

        stage('Run Nginx') {  
            bat 'docker run -d -p 80:80 --name mynginx nginx:latest'
        }

        stage('Run image') {   
            bat 'docker ps'
            bat 'curl http://localhost' 
            
        }
 
        stage('Cleanup') {
            bat 'docker rm -f mynginx'
        } 
}
