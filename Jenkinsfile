pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9.9'
        jdk 'JDK 17'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compilando el proyecto con Maven...'
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Ejecutando las pruebas con JUnit...'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Empaquetando el proyecto...'
                bat 'mvn package -DskipTests'
            }
        }
    }
    
    post {
        always {
            echo 'El Pipeline ha terminado.'
        }
        success {
            echo 'El Pipeline fue exitoso.'
        }
        failure {
            echo 'El Pipeline falló.'
        }
    }
}
