node {

    stage('Clone') {  
        bat 'rmdir /s /q dcbs-DigitalCoreBankingSystem'
        bat 'rmdir /s /q dockerCompo'
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
    
    stage('Cleanup Av') { 
        bat 'docker rm -f user-doc 2>nul || exit 0' 
        bat 'docker rm -f kafka 2>nul || exit 0' 
        bat 'docker rm -f zookeeper 2>nul || exit 0' 
    }

    stage('Build Image') {  
        bat 'docker compose build --no-cache'
    }

    stage('Run Containers') {      
        bat 'docker compose up -d'
        sleep 10
    }

    stage('Test') {   
        bat 'docker ps'  
        bat 'curl http://localhost:7001/actuator/health'
    }
 
}
