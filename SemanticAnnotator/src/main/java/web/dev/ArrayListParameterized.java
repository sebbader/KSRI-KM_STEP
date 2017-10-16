package web.dev;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.semanticweb.yars.nx.Node;

import com.github.andrewoma.dexx.collection.ArrayList;

public class ArrayListParameterized<T> extends ArrayList<T> implements ParameterizedType {

	@Override
	public Type[] getActualTypeArguments() {
		
		return null;
	}

	@Override
	public Type getRawType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getOwnerType() {
		// TODO Auto-generated method stub
		return null;
	}

}
