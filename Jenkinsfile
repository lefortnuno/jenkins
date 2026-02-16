node {

    stage('Clone') {  
        bat 'dir'
        checkout scm 
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
        bat 'docker compose build --no-cache'
    }

    stage('Run Containers') {    
        bat 'docker rm -f user-service 2>nul || exit 0'  
        bat 'docker compose up -d'
        sleep 10
    }

    stage('Test') {   
        bat 'docker ps' 
        bat 'curl http://localhost:7001/users' 
        bat 'curl http://localhost:7001/actuator/health'
    }

    stage('Cleanup') { 
        bat 'docker rm -f user-service 2>nul || exit 0' 
    }
}
