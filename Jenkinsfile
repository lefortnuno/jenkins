node {

    stage('Clone') {  
        checkout scm
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
        sleep 30
    }

    stage('Cleanup') {
        bat 'docker rm -f mynginx'
    }
}
