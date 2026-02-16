node {

    stage('Clone') {  
        checkout main
        bat 'dir'
    }

    stage('Test Service') {  
        dir('user-service') {
            bat 'mvn clean test'
        }
    }

    stage('Build Service') {  
        dir('user-service') {
            bat 'mvn clean install -DskipTests'
        }
    }
    
    stage('Build Image') { 
        bat 'docker build -t ac2i/nginx .'
        bat 'docker compose build --no-cache'
    }

    stage('Debug Compose') {
        bat 'dir'
        bat 'type dockerCompo.yml'
        bat 'cd dockerCompo'
        bat 'type dockerCompo.yml' 
        bat 'cd ..'
    }

    stage('Run Containers') {    
        bat 'docker rm -f user-service 2>nul || exit 0'
        bat 'docker rm -f mynginx 2>nul || exit 0'
        bat 'docker run -d -p 80:80 --name mynginx ac2i/nginx'
        // bat 'docker compose up -d'
        sleep 5
    }
    
    stage('Run Containers2') {   
        bat 'cd dockerCompo'  
        bat 'docker compose -f dockerCompo.yml up -d'
        sleep 10
        bat 'cd ..'
    }

    stage('Test') {   
        bat 'docker ps'
        bat 'curl http://localhost' 
        bat 'curl http://localhost:7001/actuator/health'
    }

    stage('Cleanup') { 
        bat 'docker rm -f user-service 2>nul || exit 0'
        bat 'docker rm -f mynginx 2>nul || exit 0' 
    }
}
