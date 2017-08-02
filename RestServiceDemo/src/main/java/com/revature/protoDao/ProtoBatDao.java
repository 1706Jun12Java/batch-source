package com.revature.protoDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.domain.*;

@Component("protoBatDao")
public class ProtoBatDao {

	public List<Bat> findAll() {
		BatType bt = new BatType("fruit");
		BatColony bc = new BatColony("ColonyOfBats1");
		Bat b1 = new Bat("Bobby",4,bt,bc);
		Bat b2 = new Bat("Bobby2",5,bt,bc);
		Bat b3 = new Bat("Bobby3",3,bt,bc);
		List<Bat> bats = new ArrayList();
		bats.add(b1);
		bats.add(b2);
		bats.add(b3);
		return bats;
	}

}
