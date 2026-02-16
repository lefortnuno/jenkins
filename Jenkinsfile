node {

    stage('Clone') {  
        bat 'dir'
    }
    
    stage('Build Image') { 
        bat 'docker build -t ac2i/nginx .'
    }

    stage('Run Container') {   
        bat 'docker rm -f mynginx 2>nul || exit 0'
        bat 'docker run -d -p 80:80 --name mynginx ac2i/nginx'
    }

    stage('Test') {   
        bat 'docker ps'
        bat 'curl http://localhost' 
        sleep 5
    }

    stage('Cleanup') {
        bat 'docker rm -f mynginx'
    }
    
    stage('Test Service') {  
        dir('user-service') {
            bat 'mvn clean test'
        }
    }
}
