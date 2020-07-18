package controllers


import play.api.mvc._
import play.api.Play.current
import play.api.db._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

object ContactForm {
    case class ContactForm(name: String, email: String, phone: String, msgSubject: String, message: String)
    val form: Form[ContactForm] = Form(
        mapping(
          "name" -> nonEmptyText,
          "email" -> email,
          "phone" -> nonEmptyText,
          "msgSubject" -> nonEmptyText,
          "message" -> nonEmptyText
        )(ContactForm.apply)(ContactForm.unapply)
    )
}
