package domain.repository;

public interface LoginRepository {
    String authenticate(String username, String password);
}
