📌 Nimble URL — URL Shortener Web Application

A full-stack URL shortener built using Spring Boot + Angular, designed as a simple and clean system with a scalable architecture mindset inspired by Bitly-style systems.

🚀 Features
🔗 Convert long URLs into short codes
🔁 Redirect short URLs to original URLs
🖥️ Simple Angular frontend UI
⚙️ REST API backend using Spring Boot
🗄️ Persistent storage using PostgreSQL
📦 Clean separation between frontend and backend
🧱 Tech Stack
Backend
Java 17+
Spring Boot
Spring Web
Spring Data JPA
PostgreSQL
Frontend
Angular
TypeScript
HTML/CSS
🏗️ System Overview

This project follows a basic URL shortener architecture, designed with future scalability in mind.

🔷 High-Level Flow
User → Angular UI → Spring Boot API → PostgreSQL → Redirect Response
⚡ URL Shortening Flow
1. User enters a long URL
2. Backend generates a unique short code
3. Mapping is stored in PostgreSQL
4. Short URL is returned to the user
🔁 Redirect Flow
User clicks short URL (/{shortCode})

→ Backend fetches original URL from DB
→ Returns HTTP 302 redirect
→ User lands on original page
