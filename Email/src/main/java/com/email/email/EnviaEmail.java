package com.email.email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EnviaEmail {

	/**
	 * @param args
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		sendEmail();

	}

	
	public static void sendEmail() throws EmailException {

		   SimpleEmail email = new SimpleEmail();

		   //Utilize o hostname do seu provedor de email

		   System.out.println("alterando hostname...");

		   email.setHostName("smtp.gmail.com");

		   //Quando a porta utilizada não é a padrão (gmail = 465)

		   email.setSmtpPort(465);

		   //Adicione os destinatários

		   email.addTo("alcirbarros@hotmail.com.br", "alcirEnvio");

		   //Configure o seu email do qual enviará

		   email.setFrom("alcirbarros1@gmail.com", "Seu nome");

		   //Adicione um assunto

		   email.setSubject("Test message");

		   //Adicione a mensagem do email

		   email.setMsg("Teste");

		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo

		   System.out.println("autenticando...");

		   email.setSSL(true);

		   email.setAuthentication("alcirbarros1@gmail.com", "88110763");

		   System.out.println("enviando...");

		   email.send();

		   System.out.println("Email enviado!");

		}

}