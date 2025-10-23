Voici un **README.md** complet, bien structuré et professionnel pour ton projet e-commerce microservices en Spring Boot :

---

# 🛍️ E-commerce Microservices – Spring Boot, Kafka, Keycloak, PostgreSQL & MongoDB

## 🚀 Description du projet

Ce projet est une application **e-commerce** construite sur une **architecture microservices** avec **Spring Boot**.
Il met en œuvre des communications **synchrones** via **REST** et **asynchrones** via **Apache Kafka**, tout en intégrant une sécurité avancée avec **Keycloak**.
L’objectif est de proposer une plateforme modulaire, évolutive et sécurisée, illustrant les bonnes pratiques du développement back-end moderne.

---

## 🧩 Architecture

L’application est composée de plusieurs microservices indépendants, chacun responsable d’un domaine fonctionnel précis :

* **Service Produit** – Gestion des produits (CRUD)
* **Service Commande** – Gestion des commandes et de leur statut
* **Service Stock** – Gestion des niveaux de stock
* **Service Paiement** – Simulation du processus de paiement
* **Service Notification** – Envoi d’e-mails automatiques lors des événements (ex. commande confirmée)
* **Service Gateway / API Gateway** – Point d’entrée unique vers les microservices
* **Service Authentification (Keycloak)** – Gestion centralisée des utilisateurs, rôles et permissions

Les communications inter-services se font :

* **REST (synchrones)** pour les appels classiques entre microservices.
* **Kafka (asynchrones)** pour la propagation d’événements et la communication event-driven.

---

## 🛠️ Technologies utilisées

| Domaine                          | Technologies                                |
| -------------------------------- | ------------------------------------------- |
| **Langage**                      | Java 17                                     |
| **Framework principal**          | Spring Boot 3                               |
| **Sécurité**                     | Spring Security → Keycloak                  |
| **Communication**                | REST, Apache Kafka                          |
| **Base de données**              | PostgreSQL (relationnelle), MongoDB (NoSQL) |
| **Gestion des dépendances**      | Maven                                       |
| **Messagerie asynchrone**        | Kafka                                       |
| **Tests unitaires**              | JUnit, Mockito                              |
| **Conteneurisation (optionnel)** | Docker / Docker Compose                     |

---

## ⚙️ Fonctionnalités principales

* 🧾 **CRUD complet** sur les produits et commandes
* 🔄 **Communication inter-services** (REST & Kafka)
* 🔐 **Authentification et autorisation** avec Keycloak
* 💌 **Envoi d’e-mails automatiques** (confirmation de commande, notifications, etc.)
* 🧱 **Architecture modulaire et scalable**
* 🧮 **Persistance hybride** avec PostgreSQL et MongoDB

---

## 🧰 Configuration & exécution

### 1️⃣ Prérequis

* **Java 21+**
* **Maven**
* **Docker & Docker Compose**

### 2️⃣ Cloner le dépôt

```bash
git clone https://github.com/BenLazregAhmed/ecom-microservices.git
cd ecom-microservices
```

### 3️⃣ Lancer les services avec Docker Compose

```bash
docker-compose up -d
```

### 4️⃣ Lancer les microservices

Chaque microservice peut être démarré individuellement :

```bash
cd service-name
mvn spring-boot:run
```

### 5️⃣ Accès Keycloak

* URL : `http://localhost:8080/auth`
* Realm : `ecommerce-realm`
* Client : `ecommerce-client`

---

## 📬 Envoi d’e-mails

L’envoi d’e-mails est implémenté via le service **Notification**.

---

## 🧑‍💻 Auteur

**Ahmed BenLazreg**
🎓 Étudiant ingénieur en génie logiciel à l’ISIM Monastir
💼 Passionné par le développement backend, DevOps et les architectures distribuées
📧 [benlazregahmed328@gmail.com](mailto:benlazregahmed328@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/ahmed-benlazreg-9b34a6261/) | [GitHub](https://github.com/BenLazregAhmed)

---

## 🏁 Objectif pédagogique

Ce projet a été réalisé dans le but d’approfondir la compréhension des **architectures microservices**,
de la **communication event-driven** avec Kafka, et de l’intégration d’un **système de sécurité moderne** (Keycloak) dans un environnement distribué.

---

Souhaites-tu que je te génère aussi un **diagramme d’architecture (image)** pour l’ajouter au README (montrant les microservices, Kafka, Keycloak, DBs, etc.) ?
