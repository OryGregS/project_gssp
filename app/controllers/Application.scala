package controllers

import play.api.mvc._


object Application extends Controller {

  def index: Action[AnyContent] = Action {
    Ok(views.html.index(null))
  }

  def getSSLCert(file: String): Action[AnyContent] = Action {
    if (file.equals("3qK4FB8a64hhG11dcHRN5VWF_Lq9d4Fh4pPB3Bo7h1U"))
      Ok("3qK4FB8a64hhG11dcHRN5VWF_Lq9d4Fh4pPB3Bo7h1U.CXanYYijVNvak8yzG3PrwXcbGxdT8khmsna8EuCa1x4")
    else
      NoContent
  }

  def submit: Action[AnyContent] = Action { implicit request =>
    ContactForm.form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(formWithErrors.errors.toString)
      },
      formData => {
        Ok(formData.toString)
      }
    )
  }
}
