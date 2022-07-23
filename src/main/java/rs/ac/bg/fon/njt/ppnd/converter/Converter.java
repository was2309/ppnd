package rs.ac.bg.fon.njt.ppnd.converter;

public interface Converter <D,E>{
	
	public E toEntity(D d);
	
	public D toDto(E e);

}
