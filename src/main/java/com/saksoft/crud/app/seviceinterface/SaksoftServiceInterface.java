package com.saksoft.crud.app.seviceinterface;

import com.saksoft.crud.app.model.SaksoftModel;

public interface SaksoftServiceInterface {

	public SaksoftModel registerData(SaksoftModel model);

	public Iterable<SaksoftModel> saksoftInfo();

	public SaksoftModel saksoftInfo(Integer id);

	public SaksoftModel updateData(Integer id, SaksoftModel smodel);

	public SaksoftModel removeData(Integer id);

}
