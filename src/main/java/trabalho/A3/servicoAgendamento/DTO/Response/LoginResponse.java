package trabalho.A3.servicoAgendamento.DTO.Response;

public class LoginResponse {

    private Integer id;
    private String email;
    private String nome;
    private Boolean ehTrabalhador;

    public LoginResponse() {
    }

    public LoginResponse(Integer id, String email, String nome, Boolean ehTrabalhador) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.ehTrabalhador = ehTrabalhador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getEhTrabalhador() {
        return ehTrabalhador;
    }

    public void setEhTrabalhador(Boolean ehTrabalhador) {
        this.ehTrabalhador = ehTrabalhador;
    }
}
