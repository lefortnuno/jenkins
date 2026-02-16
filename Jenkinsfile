node {

    stage('Clone') {  
        bat 'dir'
    }

    stage('Test Service') {  
        dir('user-service') {
            bat 'mvn clean test'
        }
    }
     
}
