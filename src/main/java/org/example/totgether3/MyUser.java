package org.example.totgether3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.apache.catalina.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password; // Хранить в хешированном виде



    // Параметризированный конструктор
    public MyUser(String login, String password) {
        this.login = login;
        this.password = hashPassword(password); // Хешируем пароль при создании пользователя

    }

    public MyUser() {

    }

    // Статический метод для создания нового пользователя
    public static MyUser create(String login, String password) {
        return new MyUser(login, password);
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password; // Возвращаем хешированный пароль
    }



    // Сеттеры
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password); // Хешируем новый пароль
    }



    // Метод для хеширования пароля
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b)); // Преобразуем байты в шестнадцатеричный формат
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Метод для проверки пароля
    public boolean checkPassword(String password) {
        return this.password.equals(hashPassword(password)); // Сравниваем хеши
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\''  +
                '}';
    }
}