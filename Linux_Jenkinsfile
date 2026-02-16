node {
    stage('Clone') {
        git branch: 'main', url: 'https://github.com/lefortnuno/jenkins.git'
        sh 'ls'
    }
    stage('Build') {
        sh 'javac Main.java'
    }
    stage('Run') {
        sh 'java Main'
    }
}