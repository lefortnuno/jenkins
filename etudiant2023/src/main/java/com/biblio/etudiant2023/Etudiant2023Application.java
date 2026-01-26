package com.biblio.etudiant2023;

import com.biblio.etudiant2023.entities.Etudiant;
import com.biblio.etudiant2023.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Etudiant2023Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Etudiant2023Application.class, args);

        // ferme l'app proprement après le runner
        SpringApplication.exit(context, () -> 0);
    }

    @Bean
    CommandLineRunner run(EtudiantRepository etudiantRepository) {
        return args -> {

            System.out.println("\n\n\n\n\n\n\nHello, Trofel!\n");

            etudiantRepository.save(
                    Etudiant.builder()
                            .firstName("John")
                            .lastName("Doe")
                            .email("Johndoe@gmail.com")
                            .age(25)
                            .build()
            );

            etudiantRepository.save(
                    Etudiant.builder()
                            .firstName("Saad")
                            .lastName("Mohamed")
                            .email("Saadmohammed@gmail.com")
                            .age(18)
                            .build()
            );

            etudiantRepository.save(
                    Etudiant.builder()
                            .firstName("Widad")
                            .lastName("Mohammed")
                            .email("widadmohamed@gmail.com")
                            .age(35)
                            .build()
            );

            System.out.println("Étudiants créés. Fermeture de l'application... \n\n\n\n\n\n\n");
        };
    }
}
