package controllers

import play.api.mvc._
import play.api.Play.current
import play.api.db._

object Application extends Controller {

  def index: Action[AnyContent] = Action {
    Ok(views.html.index(null))
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
