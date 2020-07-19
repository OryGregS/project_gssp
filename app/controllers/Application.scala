package controllers

import play.api.mvc._

object Application extends Controller {

  def index: Action[AnyContent] = Action {
    Ok(views.html.index(null))
  }

  def getSSLCert(file: String): Action[AnyContent] = Action {
    Redirect(routes.Assets.at(".well-known/acme-challenge/" + file))
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
