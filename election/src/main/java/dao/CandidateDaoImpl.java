package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Candidate;

public class CandidateDaoImpl {
    
    private Connection connection;

    public CandidateDaoImpl() throws Exception {
        // Load the JDBC driver (e.g., MySQL)
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";
        connection = DriverManager.getConnection(url, username, password);
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Candidate> findAll() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                candidates.add(extractCandidate(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error finding all candidates", e);
        }
        return candidates;
    }

    public List<Candidate> findByParty(String party) throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates WHERE party = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, party);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                candidates.add(extractCandidate(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error finding candidates by party", e);
        }
        return candidates;
    }

    public List<Candidate> findAllOrderByVotesDesc() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates ORDER BY votes DESC";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                candidates.add(extractCandidate(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error finding all candidates ordered by votes", e);
        }
        return candidates;
    }

    public int save(Candidate candidate) throws Exception {
        String query = "INSERT INTO candidates (name, party, votes) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getParty());
            statement.setInt(3, candidate.getVotes());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    candidate.setId(generatedKeys.getInt(1));
                }
            }
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error saving candidate", e);
        }
    }

    public int deleteById(int id) throws Exception {
        String query = "DELETE FROM candidates WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error deleting candidate by ID", e);
        }
    }

    public int update(Candidate candidate) throws Exception {
        String query = "UPDATE candidates SET name = ?, party = ?, votes = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getParty());
            statement.setInt(3, candidate.getVotes());
            statement.setInt(4, candidate.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error updating candidate", e);
        }
    }

    public Candidate findById(int id) throws Exception {
        String query = "SELECT * FROM candidates WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractCandidate(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error finding candidate by ID", e);
        }
        return null;
    }

    public int incrementVotes(int id) throws Exception {
        String query = "UPDATE candidates SET votes = votes + 1 WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error incrementing votes for candidate", e);
        }
    }

    private Candidate extractCandidate(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String party = resultSet.getString("party");
        int votes = resultSet.getInt("votes");
        return new Candidate(id, name, party, votes);
    }
}
