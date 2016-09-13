package clone;

import java.io.*;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException, Exception {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(11);
        pessoa1.setNome("Lucas");

        Endereco endereco = new Endereco();
        endereco.setCidade("São José dos Campos");
        endereco.setBairro("JD AMERICA");
        endereco.setRua("9 de Julho");
        endereco.setNumero("44");

        pessoa1.setEndereco(endereco);

        Pessoa pessoa2 = (Pessoa) ObjectCloner.deepCopy(pessoa1);
        pessoa2.setNome("AAAAA");
        pessoa2.getEndereco().setCidade("São João da Boa Vista");
    }
}

class ObjectCloner {

    public static Object deepCopy(Object oldObj) throws Exception {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(); // A
            oos = new ObjectOutputStream(bos); // B
            // serialize and pass the object
            oos.writeObject(oldObj);   // C
            oos.flush();               // D
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray()); // E
            ois = new ObjectInputStream(bin);                  // F
            // return the new object
            return ois.readObject(); // G
        } catch (Exception e) {
            System.out.println("Exception in ObjectCloner = " + e);
            throw (e);
        } finally {
            oos.close();
            ois.close();
        }
    }

}

class Endereco implements Cloneable {

    private Integer id;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public Endereco clone() throws CloneNotSupportedException {
        return (Endereco) super.clone();
    }
}

class Pessoa implements Cloneable {

    private Integer id;
    private String nome;

    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public Pessoa clone() throws CloneNotSupportedException {
        Pessoa pessoa = (Pessoa) super.clone();
        pessoa.setEndereco(pessoa.endereco.clone());
        return pessoa;
    }

}
