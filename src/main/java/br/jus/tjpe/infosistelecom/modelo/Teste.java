package br.jus.tjpe.infosistelecom.modelo;

import java.util.ArrayList;

import br.jus.tjpe.infosistelecom.dao.RamalDao;
import br.jus.tjpe.infosistelecom.dao.UsuarioDao;
import br.jus.tjpe.infosistelecom.factory.LDAPConnectionFactory;
import br.jus.tjpe.infosistelecom.factory.RamalDaoFactory;
import br.jus.tjpe.infosistelecom.factory.UsuarioDaoFactory;

public class Teste {

	public static void main(String[] args) {

		// LDAPConnectionFactory.authentication("cursomed", "123456");

		// RamalDao dao = RamalDaoFactory.createRamalDao();
		//
		// ArrayList<Ramal> ramais = dao.listarTudo();
		//
		// System.out.println(ramais.get(8000).getFone());
		//
		// for (Ramal ramal : ramais) {
		// System.out.println(ramal.getOrgao().getCidade());
		// System.out.println(ramal.getCentroDeCusto());
		//
		// System.out.println(ramal.getFone());
		// }

		// RamalDao dao = RamalDaoFactory.createRamalDao();
		//
		// Comarca c = new Comarca();
		// c.setBairro("São José");
		// c.setCentroDeCusto(1751060800);
		//
		// ArrayList<Ramal> ramais = dao.buscarTudoPorComarca(c);
		//
		// for (Ramal ramal : ramais) {
		// System.out.println(ramal.getCentroDeCusto());
		// System.out.println(ramal.getNomeUsuario());
		// System.out.println(ramal.getNumero());
		// System.out.println(ramal.getSetor());
		// System.out.println(ramal.getComarca());
		// System.out.println(ramal.getPolo());
		// System.out.println(ramal.getOrgao());
		// }

		UsuarioDao dao = UsuarioDaoFactory.createUsuarioDao();
		Usuario t = new Usuario();
		t.setLogin("amesantos");

		t = dao.buscar(t);
		System.out.println(t.getMatricula());
		
		//
		// MessageDigest algorithm;
		// try {
		// algorithm = MessageDigest.getInstance("SHA-256");
		// byte messageDigest[] = algorithm.digest("teste".getBytes("UTF-8"));
		// StringBuilder hexString = new StringBuilder();
		// for (byte b : messageDigest) {
		// hexString.append(String.format("%02X", 0xFF & b));
		// }
		// String senha = hexString.toString();
		// System.out.println(senha);
		// System.out.println(t.getSenha());
		// if (senha.equals(t.getSenha())) {
		// System.out.println("CONFERENREE");
		// }
		// } catch (NoSuchAlgorithmException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		//
		// try {
		//
		// BufferedImage imageBuffer = ImageIO.read(new
		// File("d:/IMG_20140520_124835.jpg"));
		// System.out.println(imageBuffer.getHeight());
		// System.out.println(imageBuffer.getWidth());
		//
		// BufferedImage imageTemp = new BufferedImage(imageBuffer.getWidth()/2,
		// imageBuffer.getHeight()/2, imageBuffer.TYPE_INT_RGB);
		// Graphics2D grafico = (Graphics2D) imageTemp.getGraphics();
		// grafico.drawImage(imageBuffer, 0, 0, imageBuffer.getWidth()/2,
		// imageBuffer.getHeight()/2, null);
		// grafico.dispose();
		// ImageIO.write(imageTemp, "jpg", new File("d:/t.jpg"));
		//
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }
		//

		// Comarca c = new Comarca();
		// c.setCidade("Agrestina");
		// FotoDao dao = FotoDaoFactory.createFotoDao();
		// ArrayList<Foto> fotos = dao.listarTudo(c);
		//
		// System.out.println(fotos.get(0).getComarca());
		// System.out.println(fotos.get(0).getNome());
		// System.out.println(fotos.get(0).getEndereco());
		//
		// Usuario t = new Usuario();
		// t.setLogin("amesantos");
		// t.setSenha("12345");
		//
		// UsuarioDao dao = UsuarioDaoFactory.createTecnicoDao();
		// Usuario temp = dao.buscar(t);
		//
		// System.out.println(temp.getLogin());
		// System.out.println(temp.getMatricula());
		// System.out.println(temp.getNome());
		// System.out.println(temp.getPolo());
		// System.out.println(temp.getSenha());

	}
}