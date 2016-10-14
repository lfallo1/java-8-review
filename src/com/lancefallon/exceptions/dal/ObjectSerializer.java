package com.lancefallon.exceptions.dal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;

public interface ObjectSerializer<T, U extends Collection<T>> {
	public void serialize(DataOutputStream dos, U list) throws IOException;
	public U deserialize(DataInputStream dis) throws IOException;
}
